public class Person
{
  private String name;
  private int    id;
  private static int personCount = 0;

  // constructor
  public Person(String pname)
  {
    name = pname;
    personCount++;
    id = 100 + personCount;
  }
  public Person()
  {
    name = "N/A";
    personCount++;
    id = -1;
  }

  public String  toString()
  {
    return "name: " + name + "  id: " + id 
      + "  (Person count: " + personCount + ")";
  }

  // static/class method
  public static int getCount()
  {
    return personCount;
  }

public void reset(String newName, int newID)
{
name = newName;
id = newID;
}//End of reset()

public String getName()
{
return name;
}//End getName

public int getID()
{
return id;
}//End getID
  
}
