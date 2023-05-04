class Solution {
public:
    string predictPartyVictory(string senate) {
		queue<int> qr, qd;
		for (int i = 0; i < (int)senate.size(); ++i) {
			if(senate[i]=='R') qr.push(i);
			else qd.push(i);
		}
		while((qr.empty()==false)&&(qd.empty()==false)){
			if(qr.front()<qd.front()){
				qd.pop();
				qr.push(qr.front()+senate.size());
				qr.pop();
			}
			else{
				qr.pop();
				qd.push(qd.front()+senate.size());
				qd.pop();
			}
		}
		return qr.empty()?"Dire":"Radiant";
    }
};