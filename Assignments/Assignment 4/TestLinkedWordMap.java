public class TestLinkedWordMap {

 public static void main(String[] args) {
  LinkedWordMap map = new LinkedWordMap();
  System.out.println(map.size()+" is the size of the empty map");
  map.update("hey");
  map.update("hey");
  map.update("hey");
  map.update("bob");
  System.out.println(map.get("hey")+" is the number of times 'hey' appears in the map");

  System.out.println(map.get("hey")+" is the number of times 'hey' appears in the map");
  System.out.println(map.get("bob")+" is the number of times 'bob' appears in the map");
  String[] keys = map.keys();
  Integer[] counts = map.counts();
  System.out.println("The keys are : ");
  for (int i = 0; i < keys.length; i++) {
   System.out.println(keys[i]+" appears "+counts[i]);
  }
  System.out.println("Is hey in the map : "+map.contains("hey"));
  System.out.println("Is bob in the map : "+map.contains("bob"));
  System.out.println("Is goo in the map: "+map.contains("goo"));
 }
}
