// Jai Ganesh
class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int src) {
        vector<vector<pair<int, int>>> adjList(n+1);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        
        vector<int> distance(n+1, 1e9);
        // fill the Adjacency list
        for(int index=0; index<times.size(); index++) {
            int source = times[index][0];
            int dest = times[index][1];
            int wt = times[index][2];

            adjList[source].push_back({wt, dest});
        }

        distance[src] = 0;
        pq.push({0, src});

        // push the source node
        while(!pq.empty()) {
            int wt = pq.top().first;
            int node = pq.top().second;
            pq.pop();

            for(auto neighbour: adjList[node]) {
                int dist = neighbour.first;
                int adjNode = neighbour.second;
                // cout<<" neighbour node "<<adjNode<<" for node "<<node<<" wt "<<dist<<" distance[adjNode] "<<distance[adjNode]<<endl;

                if(distance[adjNode] > distance[node] + dist) {
                    distance[adjNode] = distance[node] + dist;
                    // cout<<"came in "<<distance[adjNode]<<endl;
                    pq.push({distance[adjNode], adjNode});
                }
            }
        }

        int ans = 0;

        for(int node = 1; node<=n; node++) {
            if(distance[node] == 1e9) {
                ans = -1;
                break;
            }
            ans = max(ans, distance[node]);
        }

        return ans > 0 ? ans : -1;
    }
};
