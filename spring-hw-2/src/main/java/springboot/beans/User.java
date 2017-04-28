package springboot.beans;

public class User { 
 
    private Long id; 
    private String name; 
    private Integer age; 
 
    public Long getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public Integer getAge(){
        return this.age;
    }
    public void setId(Long id){
        this.id = id;
    }
    public void setName(String n){
        this.name = n;
    }
    public void setAge(Integer a){
        this.age = a;
    }
}