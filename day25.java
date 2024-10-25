//1233 Remove Sub-Folders from the Filesystem
//subfolder problem , pretty straight forward
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        //sort the array
        Arrays.sort(folder);
        //this is the answer
        List<String> answer=new ArrayList<>();
        //the first element will always be a prefix
        answer.add(folder[0]);
        //start from 1
        for(int i=1;i<folder.length;i++){
            //get the current el
            String current=folder[i];
            //get the previos from the last of list
            String prev=answer.get(answer.size()-1);
            //add a / beacause there might be a case where the subfolder has two characters and only one of them matches
            prev+="/";
            //use the inbuilt method to check
            if(!current.startsWith(prev)){
                answer.add(current);
            }
        }
        return answer;
    }
}
