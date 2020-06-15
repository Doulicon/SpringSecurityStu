package fyq.study.entity;

import fyq.study.constant.enums.RespCode;

/**
 * @author fengyongquan
 */
public class RespEntity {
	/**
	 * 状态码信息
	 */
	private int code;

	/**
	 * 状态信息
	 */
	private String msg;
	/**
	 * 实体类信息
	 */
	private Object data;
    private int sign;
    
    public RespEntity(RespCode respCode){
        this.code=respCode.getCode();
        this.msg=respCode.getMsg();
    }

    public RespEntity(){

    }
    
    public RespEntity(int sign,Object userData){
        this.sign=sign;
        this.data=userData;
    }
    
    public RespEntity(RespCode respCode, Object userData){
    	this(respCode);
        this.data=userData;
    }
    
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getSign() {
		return sign;
	}

	public void setSign(int sign) {
		this.sign = sign;
	}

	@Override
    public String toString() {
        return "RespEntity{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", sign=" + sign +
                '}';
    }
    
}
