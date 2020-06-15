package fyq.study.constant.enums;

/**
 * 状态码
 * @author temp
 *
 */
public enum RespCode {
	
		SUCCESS(0,"操作成功"),
	    ERROR(403,"失败"),
	    OK(200,"OK");


	    private int code;
	    private String msg;
	    RespCode(int code, String msg){
	        this.code=code;
	        this.msg=msg;
	    }
	    public int getCode(){
	        return code;
	    }
	    public String getMsg(){
	        return msg;
	    }

}
