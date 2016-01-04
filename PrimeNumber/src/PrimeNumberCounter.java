import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PrimeNumberCounter {
	//キャッシュバッファ
	private static Map<Integer, Integer> primeNumber = new HashMap<>();
	static{
		primeNumber.put(0, 0);
		primeNumber.put(1, 0);
		primeNumber.put(2, 1);
		primeNumber.put(3, 2);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line = br.readLine())!= null) {
			int count = Integer.parseInt(line);
			System.out.println(countPrimeNumber(count));
		}
	}

	//再帰を使った方法
	private static int countPrimeNumber(int num) {
		//偶数nの素数の個数は奇数n-1の素数の個数と同じ。
		//2,3のみは特別扱いとし、素数を算出する対象を調整。
		num = (num % 2 == 0 && num > 2) ? num-1 : num;
		if(primeNumber.containsKey(num)) {
			return primeNumber.get(num);
		}

		boolean isPrime = true;
		//「エラトステネスのふるい」という手段。
		for(int i = 3; i * i <= num; i++) {
			if(num % i== 0) {
				isPrime = false;
				break;
			}
		}
		//例えばcountPrimeNumber(5) = countPrimeNumber(3) + ( 1 or 0 ) を表現
		int value = countPrimeNumber(num-2) + (isPrime ? 1 : 0);
		primeNumber.put(num, value);		//キャッシュ
		return value;
	}
}
