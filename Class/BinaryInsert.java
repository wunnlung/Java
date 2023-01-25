public class BinaryInsert{
	public long[] insert(long value, long[] a){
		if(nElems==0){
			a[0] = value;
		}else{
			int lo = 0;
			int hi = nElems-1;
			int mid = 0;
			boolean foundIt = false;   //flag when we've found the position so the loop will stop
			while (!foundIt && lo <= hi){
				mid = lo + (hi-lo)/2;
				if(a[mid]<value){
					lo=mid+1;
				} else if(a[mid]>value){
					hi=mid-1;
				} else if(a[mid]==value){
					foundIt = true;
				}
			}

			for(int k=nElems; k>mid-1; k--) {  // shift all bigger elements up
				a[k] = a[k-1];
			}
			a[mid] = value;
			nElems++;
			
		}
	return a;

	}

	public static void main(String[] args) {
		long[] arr = {};
		long a = 1;
		long b = 5;
		System.out.println(insert(a,arr));
		System.out.println(insert(b,arr));
	}
}