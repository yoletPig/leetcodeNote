package Hash;
import	java.util.ArrayList;

import	java.util.HashMap;

import java.util.List;

/**
 * 690.员工的重要性
 * 难度
 * 简单
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
 *
 * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
 *
 * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
 *
 * 示例 1:
 *
 * 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * 输出: 11
 * 解释:
 * 员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
 * 注意:
 *
 * 一个员工最多有一个直系领导，但是可以有多个直系下属
 * 员工数量不超过2000。
 */
public class getImportance {
    HashMap<Integer, List<Integer>> map = null;
    int sum = 0;

    /**
     * 我的解法：拿到题就想到了dfs，只有list还有元素就递归下去，用map存id跟对应的列表，列表最后是重要度。
     * @param employees
     * @param id
     * @return
     */
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<> ();
        List<Integer> list = null;
        for (Employee employee : employees) {
            if (employee.id == id){
                list = employee.subordinates;
            }
            employee.subordinates.add(employee.importance);
            map.put(employee.id,employee.subordinates);
        }
        f(list);
        return sum;
    }
    private void f(List<Integer> list){
        sum+=list.get(list.size() -1);
        if (list.size()<=1){
            return;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            f(map.get(list.get(i)));
        }
    }

    /**
     * 解法二：不用map，用队列的思想，一直对员工集合进行循环，如果是队头相同，就加上它的重要度然后出队，它的属下入队，
     * 直到队列为空退出循环。
     * 时间复杂度高，但还是值得学习。
     * @param employees
     * @param id
     * @return
     */
    public int getImportance1(List<Employee> employees, int id) {
        int imp = 0;
        List<Integer> list = new ArrayList<>();
        list.add(id);
        while(list.size()>0){
            for(Employee e:employees){
                if(e.id==list.get(0)){
                    imp+=e.importance;
                    list.addAll(e.subordinates);
                    employees.remove(e);
                    list.remove(0);
                    break;
                }
            }
        }
        return imp;
    }


    public static void main(String[] args) {
        getImportance gi = new getImportance();
        List<Employee> employees = new ArrayList<> ();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        employees.add(new Employee(1,5,list));
        employees.add(new Employee(2,3,new ArrayList<> ()));
        employees.add(new Employee(3,3,new ArrayList<> ()));
        System.out.println(gi.getImportance(employees,1));
    }
}
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
};
