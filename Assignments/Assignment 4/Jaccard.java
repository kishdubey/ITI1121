public class Jaccard implements Similarity{
  private String[] linkedArray;
  private String[] treeArray;
  private String[] unionArray;
  private String[] intersectionArray;

  public double score(WordMap list,WordMap tree) {
    linkedArray = list.keys();
    treeArray = tree.keys();

    int less = treeArray.length;
    if(treeArray.length > linkedArray.length){
      less = linkedArray.length;
    }

    unionArray = new String[linkedArray.length + treeArray.length];
    intersectionArray = new String[less];

    for(int i=0; i<linkedArray.length; i++){
      unionArray[i] = linkedArray[i];
    }

    int size = linkedArray.length;
    int intersection = 0;

    for(int j=0; j<treeArray.length; j++){
      if(!contains(treeArray[j])){
        unionArray[size] = treeArray[j];
        size++;
      }
      else{
        intersectionArray[intersection] = treeArray[j];
        intersection++;
      }
    }

    double counterU = isNull(unionArray);
    double counterI = isNull(intersectionArray);

    return counterI/counterU;
  }

  private boolean contains(String key){

    for(int i=0;i<unionArray.length;i++){
      if(unionArray[i] != null){
        if(unionArray[i].equals(key)){
          return true;
        }
      }
    }
    return false;
  }

  private int isNull(String[] array){
    int counter = 0;
    for(int a=0; a<array.length; a++){
      if(array[a] == null){
        counter++;
      }
    }
    return array.length - counter;
  }
}
