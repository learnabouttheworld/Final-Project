public class Ghost{
    private int xcor;
    private int ycor;
    
    

    public Ghost(){
	xcor = 10;
	ycor = 5;
    }

    public int getX(){
	return xcor;
    }
    public int getY(){
	return ycor;
    }

    public void setX(int xcor){
	this.xcor = xcor;
    }
    public void setY(int ycor){
	this.ycor = ycor;
    }
}