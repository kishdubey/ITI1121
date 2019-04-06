//ATTEMPT at Cosine, does not seem to work as of now. Will update when I figure it out :/

public class Cosine implements Similarity{
  private String[] linkedArray;
  private String[] treeArray;


  public double score(WordMap list, WordMap tree){
    linkedArray = list.keys();
    treeArray = tree.keys();

        	double sumProduct = 0;
          double sumA = 0;
          double sumB = 0;
        	double sumASq = 0;
        	double sumBSq = 0;

          for(int i=0; i<linkedArray.length; i++){
            sumA += list.get(linkedArray[i]);
            sumASq += list.get(linkedArray[i]) * list.get(linkedArray[i]);
          }

          for(int j=0; j<treeArray.length; j++){
            sumB += tree.get(treeArray[j]);
            sumBSq += tree.get(treeArray[j]) * tree.get(treeArray[j]);
          }

          int size = treeArray.length;
          if(linkedArray.length < treeArray.length){
            size = linkedArray.length;
          }

          for(int a=0; a<size; a++){
            sumProduct = list.get(linkedArray[a]) * tree.get(treeArray[a]);
          }

        	return sumProduct / (Math.sqrt(sumASq) * Math.sqrt(sumBSq));
  }
}
