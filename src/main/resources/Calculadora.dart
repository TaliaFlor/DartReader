import 'dart:io';

void main() {
	print('Escolha um n�mero:');
  var a = double.parse(stdin.readLineSync());
	print('Escolha outro n�mero:');
  var b = double.parse(stdin.readLineSync());
  print('Soma - 1');
  print('Subtra��o - 2');
  print('Divis�o - 3');
  print('Multiplica��o - 4');
  var op = int.parse(stdin.readLineSync());
  
  var result;
  if(op == 1){
    result = a + b;
  }else if(op == 2){
    result = a - b;
  }else if(op == 3){
    result = a / b;
  } else if(op == 4){
    result = a * b;
  }
  
  print('O resultado �: ' + result);
}