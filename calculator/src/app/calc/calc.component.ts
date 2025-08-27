import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-calc',
  imports: [FormsModule],
  templateUrl: './calc.component.html',
  styleUrl: './calc.component.css'
})
export class CalcComponent {
   
  num1:number=0;
  num2:number=0;
  result:number=0;

  addNumbers(){
    this.result=this.num1+this.num2;
  }
  subNum(){
    this.result=this.num1-this.num2;
  }

  mulNum(){
    this.result=this.num1*this.num2;
  }
  divNum(){
     this.result=this.num1/this.num2;
  }
}
