package leetcode;

/**
 * 
 * <p>在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。</p>
 * <p>每个矩形由其左下顶点和右上顶点坐标表示，如图所示。</p>
 * 
 * <p><strong>示例:</strong></br>
 * 输入: -3, 0, 3, 4, 0, -1, 9, 2 输出: 45</p>
 * <p><strong>说明:</strong> 假设矩形面积不会超出 int 的范围。</p>
 * 
 * @author Cytus_
 * @since 2018年9月21日 下午4:18:45
 * @version 1.0
 */
public class _0223RectangularArea {
	
	public static void main(String[] args) {
		System.out.println(computeArea(-2,-2,2,2,-2,-2,2,2));
	}

	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int oneArea = Math.abs((A - C) * (B - D));
		int twoArea = Math.abs((E - G) * (F - H));
		
		if ((E <= A && G <= A) || (E >= C && G >= C) || (H <= B && F <= B) || (F >= D && H >= D)) {
			return oneArea + twoArea;
		} else {
			int intersectionArea = Math.abs((min(G, C) - max(A, E)) * (min (H, D) - max(B, F)));
			return oneArea + twoArea - intersectionArea;
		}
    }
	
	public static int min(int a, int b) {
		return a < b ? a : b;
	}
	
	public static int max(int a, int b) {
		return a > b ? a : b;
	}
	
}
