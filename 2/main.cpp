#include <iostream>
using namespace std;

int main() {
  int lines, minn, maxx;
  string inp;
  cin >> lines >> minn >> maxx;
  cin >> inp;
  int inpLength = inp.size();
  int lettersRoundUp = (inpLength + lines - 1) / lines;
  int lettersRemain = inpLength % lines;
  int lettersRoundDown = inpLength /= lines;

  if (lettersRoundUp > maxx || lettersRoundDown < minn) {
    cout << "No solution";
    return 0;
  }
  if (lettersRemain != 0)
    if (minn == maxx) {
      cout << "No solution";
      return 0;
    }
  for (int i = 0; i < lettersRemain; ++i) {
    string ansLine = "";
    for (int j = 0; j < lettersRoundDown + 1; ++j) {
      ansLine += inp[j];
    }
    cout << ansLine << endl;
    inp.erase(0, lettersRoundDown + 1);
  }
  for (int i = lettersRemain; i < lines; ++i) {
    string ansLine = "";
    for (int j = 0; j < lettersRoundDown; ++j) {
      ansLine += inp[j];
    }
    cout << ansLine << endl;
    inp.erase(0, lettersRoundDown);
  }
  return 0;
}