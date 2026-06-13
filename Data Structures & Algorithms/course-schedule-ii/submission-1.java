class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List[] adjList = new List[numCourses];
        for (int course = 0; course < numCourses; course++) { 
            adjList[course] = new ArrayList<Integer>();
        }
        for (int[] prereq: prerequisites) {
            adjList[prereq[0]].add(prereq[1]);
        }

        int[] visited = new int[numCourses];
        List<Integer> courseCollect = new ArrayList<>();
        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, adjList, visited, courseCollect)) {
                courseCollect.clear();
                break;
            }
        }
        
        int[] res = new int[courseCollect.size()];
        for (int i = 0; i < courseCollect.size(); i++) {
            res[i] = courseCollect.get(i);
        }
        return res;
    }

    private boolean dfs(int course, List<Integer>[] adjList, int[] visited, List<Integer> courseCollect) {
        if (visited[course] == 1) return false;
        if (visited[course] == 2) return true;

        visited[course] = 1;
        

        for (int prereq: adjList[course]) {
            if(!dfs(prereq, adjList, visited, courseCollect)) {
                return false;
            }
        }

        visited[course] = 2;
        courseCollect.add(course);
        return true;
    }   
}
