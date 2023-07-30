public class MIPS{

	//function to return the opcode
	public int opcode(int input){
		int mask = 0xFC000000;
		int opc = (input & mask) >>> 26;
		//System.out.println(Integer.toHexString(opc));
		return opc;
 	}

 	//function to return the first src reg
	public int src1(int input){
		int mask = 0x03E00000;
		int src = (input & mask) >>> 21;
		//System.out.println(Integer.toHexString(src));
		return src;
	}

	//function to return the second src reg
	public int src2(int input){
		int mask = 0x001F0000;
		int src = (input & mask) >>> 16;
		//System.out.println(Integer.toHexString(src));
		return src;
	}

	//function to return the destination reg
	public int dest(int input){
		int mask = 0x0000F800;
		int d = (input & mask) >>> 11;
		//System.out.println(Integer.toHexString(d));
		return d;
	}

	//function to return the x
	public int x(int input){
		int mask = 0x000007C0;
		int y = (input & mask) >>> 6;
		//System.out.println(Integer.toHexString(y));
		return y;
	}

	//function to return the function (only for r-format)
	public int func(int input){
		int mask = 0x0000003f;
		int f = (input & mask);
		//System.out.println(Integer.toHexString(f));
		return f;
	}

	//function to return the 16-bit offset (only for i-format)
	//make it a short so it can handle the two's complement on its own
	public Short offset(int input){
		int mask = 0x0000ffff;
		Short constant = (short) (input & mask);
		//Short c = (short) constant;
		//System.out.println(Integer.toHexString(constant));
		return constant;
	}

	//gets the offset, but sign-extended so it doesn't register as two's complement
	public int seo(int input){
		int mask = 0x0000ffff;
		int o = (input & mask) >>> 2;

		//check if negative
		if((o & 0x8000)!=0){
			return 0xFFFF0000 | o;
		}
		//otherwise just return the bit
		return o;
	}

}


//just a class to test that everything works
class test{
	public static void main(String[] args) {
		int test1 = 0x1c;
		int test2 = 0x00a63820;
		int test3 = 0x8d070004;
		//System.out.println(test2);
		//System.out.println(Integer.toHexString(test2));

		MIPS test = new MIPS();
		int opcTest = test.opcode(test3);
		int srcTest = test.src1(test3);
		int offsetTest = test.offset(test2);
	}
}