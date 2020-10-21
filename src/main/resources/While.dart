import 'dart:io';

void main() {
  double a = 5;
  double b = 10;
  var result = 0;
  while(a < b){
  	result = result + 1;
  	a = a + 1;
  	print('to dentro');
  }
  print('foram necessarios: ' + result + ' loops.');
}