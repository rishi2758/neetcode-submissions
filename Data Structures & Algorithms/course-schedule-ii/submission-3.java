class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // List[] adjList = new List[numCourses];
        // for (int course = 0; course < numCourses; course++) { 
        //     adjList[course] = new ArrayList<Integer>();
        // }
        // for (int[] prereq: prerequisites) {
        //     adjList[prereq[0]].add(prereq[1]);
        // }

        // int[] visited = new int[numCourses];
        // List<Integer> courseCollect = new ArrayList<>();
        // for (int course = 0; course < numCourses; course++) {
        //     if (!dfs(course, adjList, visited, courseCollect)) {
        //         courseCollect.clear();
        //         break;
        //     }
        // }
        
        // int[] res = new int[courseCollect.size()];
        // for (int i = 0; i < courseCollect.size(); i++) {
        //     res[i] = courseCollect.get(i);
        // }
        return _findOrder(numCourses, prerequisites);
    }

    private int[] _findOrder(int numCourses, int[][] prerequisites) { 
        int[] inDegree = new int[numCourses];
        List<Integer>[] adjList = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        for (int[] prereq: prerequisites) {
            adjList[prereq[1]].add(prereq[0]);
            inDegree[prereq[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        
        for (int course = 0; course < numCourses; course++) {
            if (inDegree[course] == 0) q.add(course);
        }
        
        int[] courseOrder = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            courseOrder[idx++] = course;
            for (int adj : adjList[course]) {
                inDegree[adj]--;
                if (inDegree[adj] == 0) {
                    q.add(adj);
                }
            }
        }
        return idx == numCourses ? courseOrder : new int[] {};
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
