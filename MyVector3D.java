public class MyVector3D extends Game {
     private double[] v;
     MyVector3D(double x, double y, double z){
         v = new double[3];
         v[0] = x;
         v[1] = y;
         v[2] = z;
     }
             MyVector3D(double x, double y){
 	
     }
 
            MyVector3D(double x){
 	
     }
 
            MyVector3D(){
   	
    }

           void print(){
           System.out.println("("+v[0]+", "+v[1]+", "+v[2]+")");
    }

          public static void main(String[] args){
     
          MyVector3D v1 = new MyVector3D(1,2,3);
          MyVector3D v2 = new MyVector3D(1,2);
          MyVector3D v3 = new MyVector3D(1);
          MyVector3D v4 = new MyVector3D();
          v1.print();
          v2.print();
          v3.print();
          v4.print();
          }
 }
