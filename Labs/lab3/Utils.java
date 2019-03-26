public class Utils 
{

    /**
     * Returns a copy of the array 'in' where each word occurring in the array
     * 'what' has been replaced by the word occurring in the same position
     * in the array 'with'.
     *
     * @param in an array of Strings;
     * @param what an array of words to be replaced;
     * @param with an array of replacement words;
     * @return a new array idententical to 'in' except that all the occurrences of words
     * found in 'what' have been replaced by the corresponding word from 'with'.
     */

    public static String[] findAndReplace( String[] in, String[] what, String[] with ) 
    {

        String[] out = null; // The new array to be returned
        boolean valid = true; // True if the pre-conditions are satistified

        // Testing pre-conditions

        if ( in == null || what == null || with == null ) 
        {
            valid = false;
        } 
        else 
        {
            for(int i=0; i<in.length; i++)
            {
              if(in[i] ==null)
              {
                valid=false;
              }
            }

            for(int a=0; a<what.length; a++)
            {
              if(what[a] ==null)
              {
                valid=false;
              }
            }

            for(int b=0; b<with.length; b++)
            {
              if(with[b] ==null)
              {
                valid=false;
              }
            }
            
            if(what.length != with.length)
            {
              valid = false;
            }

        if ( valid ) 
        {
        // Returning a reference to the newly created array that
        // contains the same entries as 'in' except that all the
        // occurrences of words from 'what' have been replaced by
        // their corresponding occurrence from 'with'.
            out = new String[ in.length ];
            for ( int d=0; d<in.length; d++ ) 
            {
                boolean f = false;

                for(int e=0; !f && e<what.length; e++)
                {
                  if(in[d].equals(what[e]))
                  {
                    out[d] = with[e];
                    f=true;
                  }
                }

              if(!f)
              {
                out[d]=in[d];
              }
            }
        }   
        
    }
    return out;
  }
}
        

  