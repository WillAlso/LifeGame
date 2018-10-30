package lifegame;

public class InfoMap {
	private int row;
	private int col;
	private int sleep_time;
	private int width;
	private int height;
	private int cellmap[][];
	private int timemap[][];
	
	InfoMap(){
		row = col = 60;
		sleep_time = 1000;
		width = height = 15;
		cellmap = new int[row][col];
		timemap = new int[row][col];
		for(int i = 0;i < row;i++) {
			for(int j = 0;j < col;j++) {
				timemap[i][j] = 0;
			}
		}
	}
	
	InfoMap(InfoMap t){
		row = t.row;
		col = t.col;
		sleep_time = t.sleep_time;
		width = t.width;
		height = t.height;
		cellmap = new int[row][col];
		timemap = new int[row][col];
		for(int i = 0;i < row;i++) {
			for(int j = 0;j < col;j++) {
				cellmap[i][j] = t.GetMap()[i][j];
				timemap[i][j] = t.GetTime()[i][j];
			}
		}
	}
	
	InfoMap(int row,int col,int time,int width,int height){
		SetInfo(row,col,time,width,height);
	}
	
	private void SetInfo(int row,int col,int time,int width,int height) {
		this.row = col;
		this.col = col;
		this.sleep_time = time;
		this.width = width;
		this.height = height;
		cellmap = new int[row][col];
		timemap = new int[row][col];
	}
	
	public int GetRow() {
		return row;
	}
	
	public int GetCol() {
		return col;
	}
	
	public int GetSleep() {
		return sleep_time;
	}
	
	public int GetWidth() {
		return width;
	}
	
	public int GetHeight() {
		return height;
	}
	
	public int GetLivenum() {
		int cnt = 0;
		for(int i = 0;i < row;i++) {
			for(int j = 0;j < col;j++){
				if(cellmap[i][j] != 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public void SetMap(int[][] temp) {
		for(int i = 0;i < row;i++) {
			for(int j = 0;j < col;j++) {
				cellmap[i][j] = temp[i][j];
			}
		}
	}
	
	public void SetCellTime(int row,int col,int cnt) {
		timemap[row][col] = cnt;
	}
	
	public int[][] GetMap(){
		return cellmap;
	}
	
	public int[][] GetTime(){
		return timemap;
	}
	
}
