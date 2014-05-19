import com.sun.xml.internal.ws.util.ByteArrayBuffer;





public class Test {
	public static void main(String[] args) {
		String str = "javaName";
		byte[] arr = str.getBytes();
		ByteArrayBuffer temp = new ByteArrayBuffer();
		// A~Z 65 ~ 90
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] >= 65 && arr[i] <= 90){
				temp.write('_');
				temp.write(arr[i]+32);
			}else{
				temp.write(arr[i]);
			}
		}
		System.out.println(temp.toString());
	}
}
