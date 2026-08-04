class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
        List<Integer> ans1 = new ArrayList<>();
        int max = 0,min = Integer.MAX_VALUE;
        for(int i = 0;i<ans.size();i++){
            if(ans.get(i)>max) max = ans.get(i);
            if(ans.get(i)<min) min = ans.get(i);
        }
        for(int i = min;i<=max;i++){
            if(!ans.contains(i)) ans1.add(i);
        }
        return ans1;
    }
}
