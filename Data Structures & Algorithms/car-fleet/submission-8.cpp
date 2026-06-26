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

        double lastTime = 0;
        int lastSpeed = INT_MAX;

        for(int index = len-1; index>=0; index--) {
            int pos = posAndSpeed[index].first;
            int speed = posAndSpeed[index].second;
            int distanceToCover = target - pos;
            double timeReq = (double)distanceToCover / (double)speed;
            if(timeReq > lastTime || timeReq >= lastTime && speed <= lastSpeed) {
                fleet++;
            }
            lastSpeed = min(speed, lastSpeed);
            lastTime = max(timeReq, lastTime);
        }

        return fleet;
    }
};
