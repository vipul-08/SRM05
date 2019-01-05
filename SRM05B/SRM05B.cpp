#include <bits/stdc++.h>
using namespace std;

vector<string> spliter(string str , string delimiter) {
    vector<string> res;
    int pos;
    while((pos = str.find(delimiter)) != string::npos) {
        string token = str.substr(0,pos);
        str.erase(0,pos+1);
        res.push_back(token);
    }
    res.push_back(str);
    return res;
}

int main() {
	int t;
	cin>>t;
	string temp;
	getline(cin,temp);
	string ans[t];
	for(int i = 0 ; i < t ; i++) {
	    string ip;
	    temp = ip;
	    cin>>ip;
	    if(ip.find(".") != string::npos){
	        vector<string> parts = spliter(ip,".");
	        if(parts.size() == 4) {
	            for(int j = 0 ; j < 4 ; j++) {
	                if(parts.at(j).length() == 0) {
	                    ans[i] = "invalid";
	                    break;
	                }
	                else {
	                    if(parts.at(j).at(0) == '0') {
	                        if(parts.at(j).length() == 1) {
	                            if(j<3){
	                                continue;
	                            }
	                            else if(j==3) {
	                                ans[i] = "ipv4";
	                            }
	                        }
	                        else {
	                            ans[i] = "invalid";
	                            break;
	                        }
	                    }
	                    if( regex_match( parts.at(j) , regex("[0-9]+") ) && parts.at(j).length() <= 3 ){
	                        stringstream convert(parts.at(j));
	                        int temp = 0;
	                        convert>>temp;
	                        if(temp >=0 && temp <= 255) {
                                if(j<3)
                                    continue;
                                else if(j == 3)
                                    ans[i] = "ipv4";
                            }
                            else {
                                ans[i] = "invalid";
                                break;
                            }
	                    }
	                    else {
	                        ans[i] = "invalid";
	                        break;
	                    }
	                }
	            }
	        }
	        else {
	            ans[i] = "invalid";
	        }
	    }
	    else if(ip.find(":") != string::npos){
	        vector<string> parts = spliter(ip,":");
	        if(parts.size() == 8){
	            for(int j = 0 ; j < 8 ; j++) {
	                if(parts.at(j).at(0) == '0') {
                        if(parts.at(j).length() == 1) {
                            if(j<7){
                                continue;
                            }
                            else if(j==7) {
                                ans[i] = "ipv6";
                            }
                        }
                        else {
                            ans[i] = "invalid";
                            break;
                        }
                    }
                    if( regex_match( parts.at(j) , regex("[0-9a-f]+") ) && parts.at(j).length() <= 4 ) {
                        if(j<7)
	                        continue;
	                    else if(j==7)
	                        ans[i] = "ipv6";
                    }
                    else {
	                    ans[i] = "invalid";
	                    break;
	                }
	            }
	        }
	        else {
	            ans[i] = "invalid";
	        }
	    }
	    else {
	        ans[i] = "invalid";
	    }
	}
	for(int i = 0 ; i < t ; i++) {
	    cout<<ans[i]<<endl;
	}
	return 0;
}