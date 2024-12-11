#include <iostream>

#include <cstdlib>

#include <ctime>

 

using namespace std;

 

int main() {

    float fTotalAmount = 0;

    int iTotalAmount = 0, count = 0, option = 0, i;

 

    //输入数据

    cout << "请输入总金额: ";

    cin >> fTotalAmount;

    if(fTotalAmount>0){

        iTotalAmount = 100*fTotalAmount;

    }

    else{

        cout << "总金额输入错误!\n";

        exit(1);

    }

    cout << "输入的总金额:" << (iTotalAmount/100.) << endl;

    cout << "请输入总人数: ";

    cin >> count;

    if(count > 0){

        cout << "输入的总人数: " << count <<endl;

    }

    else{

        cout << "总人数输入错误! \n";

        exit(2);

    }

    cout << "请输入发红包方式(平分模式输入 1, 随机模式输入 2): ";

    cin >> option;

    if(option<1 || option>2){

        cout << "红包模式输入错误! \n";

        exit(3);

    }

 

    //发红包（目前打印到屏幕上，将来可以存入数据表中）

    if(option==1){

        for(i=0; i<count; i++){

            cout << "红包" << (i+1) << ": " << (iTotalAmount/count/100.) << endl;

        }

        cout << "退还的金额: " << ((iTotalAmount-iTotalAmount/count*count)/100.) << endl;

    }

    else{

        int RandomRedEnvelope = 0;

 

        srand(time(NULL));

        for(i=0; i<count-1; i++){

            RandomRedEnvelope = rand()%(iTotalAmount-(count-i-1));

            iTotalAmount -= RandomRedEnvelope;

            cout << "红包" << (i+1) << ": " << (RandomRedEnvelope/100.) << endl;

        }

        cout << "红包" << (i+1) << ": " << (iTotalAmount/100.);

    }

 

    return 0;

}