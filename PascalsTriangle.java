// Given an integer numRows, return the first numRows of Pascal's triangle.
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.get(0).add(1);
        for(int i=1; i<numRows; i++){
            list.add(new ArrayList<>());
            list.get(i).add(1);
            if(i != 1){
                for(int j = 0; j < i-1; j++){
                    list.get(i).add(list.get(i-1).get(j) + list.get(i-1).get(j+1));
                }
            }
            list.get(i).add(1);
        }
        return list;
    }
}