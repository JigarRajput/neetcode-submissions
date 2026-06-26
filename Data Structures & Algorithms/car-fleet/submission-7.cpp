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
            double timeReq = (double)distanceToCover/(double)speed;
            cout<<" "<<posAndSpeed[index].first<<" "<<posAndSpeed[index].second;
            cout<<" time req "<<timeReq;

            if(timeReq > lastTime || timeReq >= lastTime && speed <= lastSpeed) {
                cout<<" fleet increasing "<<endl;
                fleet++;
            }
            cout<<endl;
            lastSpeed = min(speed, lastSpeed);//, lastSpeed);
            lastTime = max(timeReq, lastTime);//, lastTime);
        }

        return fleet;
    }
};
