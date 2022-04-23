#include <bits/stdc++.h>
using namespace std;
 
int main (){
  int k, a ,b;
  string s;
  cin >> k >> a >> b;
  cin >> s;
  int q = s.size();
  int qb = (q + k -1) / k;
  int qq = q % k ;
  q /= k;
 
  if (qb  > b || q < a){ cout << "No solution";  return 0;}
  if (q < a){ cout << "No solution";  return 0;}
  if (qq != 0)
  if (a == b)
  {cout << "No solution";  return 0;}
  for ( int i = 0 ; i < qq; i++){
  string ss = "";
  for ( int j = 0 ;  j < q+ 1 ; j++ ){
  ss += s[j];
  }
  cout << ss << endl ;
  s.erase(0,q+1);
  }
  for ( int i = qq ; i < k; i++){
  string ss = "";
  for ( int j = 0 ;  j < q ; j++ ){
  ss += s[j];
  }
  cout << ss << endl ;
  s.erase(0,q);
  }
return 0;}
