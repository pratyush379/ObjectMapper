import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
//        Employee e1 = new Employee(1,"Pratyush");
//       String jsonData =  mapper.writeValueAsString(e1);

        List<Employee> list = new ArrayList<Employee>();
        Employee e1 = new Employee(101,"Pratyush");
        Employee e2 = new Employee(102,"Rajarshi Biswas");
        list.add(e1);
        list.add(e2);
        String jsonData = mapper.writeValueAsString(list);
       // System.out.println(list);

        mapper.writeValue(new File("D:\\Devlopment\\Miscellaneous\\jsonTest\\data.json"),list);

       System.out.println(jsonData);


       //json to java

     ObjectMapper mapper1 = new ObjectMapper();
    /* ArrayList<Employee> list2 = mapper1.readValue(jsonData,ArrayList.class);
     System.out.println(list2.size());

     Iterator itr = list2.iterator();
     while (itr.hasNext())
         System.out.println(itr.next());
         */

        ArrayList<Employee> list2 = mapper1.readValue(jsonData, new TypeReference<ArrayList<Employee>>() {
        });

        list2.forEach(e->System.out.println(e1.getEmpid() + " "+ e1.getName()));

    }
}

class Employee{
    public Employee() {
    }

    private long empid;
    private String name;

    public long getEmpid() {
        return empid;
    }

    public void setEmpid(long empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee(long empid, String name) {
        this.empid = empid;
        this.name = name;
    }



}