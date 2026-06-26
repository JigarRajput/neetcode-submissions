// Jai Ganesh
class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        int fleet = 0;
        int len = position.size();

        vector<pair<int, int>> posAndSpeed;

        for(int index = 0; index<len; index++) {
            posAndSpeed.push_back({position[index], speed[index]});
        }
        
        sort(posAndSpeed.begin(), posAndSpeed.end());

        int lastTime = 0;
        int lastSpeed = 0;

        for(int index = len-1; index>=0; index--) {
            int pos = posAndSpeed[index].first;
            int speed = posAndSpeed[index].second;
            int distanceToCover = target - pos;
            int timeReq = ceil((double)distanceToCover/(double)speed);
            cout<<" time req "<<timeReq<<endl;

            if(timeReq > lastTime || speed <= lastSpeed) {
                fleet++;
            }
            lastSpeed = speed;
            lastTime = max(timeReq, lastTime);
        }

        return fleet;
    }
};
