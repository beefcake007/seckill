package org.seckill.exception;

/**
 * �ظ���ɱ�쳣(�������쳣)
 * @author fanye
 *
 */
public class RepeatKillException extends SeckillException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RepeatKillException(String message) {
		super(message);
	}

	public RepeatKillException(String message, Throwable cause) {
		super(message, cause);
	}

}
