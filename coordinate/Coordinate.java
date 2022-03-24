class Coordinate {
    int x;
    int y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Coordinate toLeft() {
        return new Coordinate(this.x, this.y-1);
    }
    
    public Coordinate toRight() {
        return new Coordinate(this.x, this.y+1);
    }
    
    public Coordinate toDown() {
        return new Coordinate(this.x+1, this.y);
    }
    
    public Coordinate toUp() {
        return new Coordinate(this.x-1, this.y);
    }
    
    public String toString() {
        return "{x=" + this.x + ",y=" + this.y + "}";
    }
}
