import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortDemo {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(20);
		list.add(3);
		list.add(10);

		/*Collections.sort(
			list,
			new Comparator<Integer>() {
				@Override
				public int compare(Integer x, Integer y) {
					return x - y;
				}
			});*/

		Collections.sort( list, (x,y) -> x - y);

		System.out.println(list);
	}
}