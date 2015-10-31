package org.aapframework.logger;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.util.MessageSupplier;
import org.apache.logging.log4j.util.ReflectionUtil;
import org.apache.logging.log4j.util.Supplier;

/**
 * Class to log INFO, DEBUG, WARN and ERROR to the console
 * 
 * @author zl
 *
 */

public enum Logger implements org.apache.logging.log4j.Logger{
	INSTANCE;
	
	private int severityLevel = Severity.DEBUG.getLevel();
	
	/**
	 * The severity of the message to log.
	 * 
	 * @author zl
	 *
	 */
	public enum Severity implements Comparable<Logger.Severity>{
		INFO(1), DEBUG(2), WARN(3),ERROR(4);
		
		private int level;
		
		Severity(int level){
			this.level = level;
		}
		
		public int getLevel(){
			return level;
		}
	}
	
	public void setReportingLevel(Severity severity){
		severityLevel = severity.level;
	}
	
	public Date date= new java.util.Date();
	
	/**
	 * Make the string to display
	 * @param mode Is the calling method INFO, DEBUG, ERROR or WARN
	 * @param arg0 The message set by the user
	 * @return The message
	 */
	private String getMessage(String mode, String arg0){
		return ((new Timestamp(date.getTime())).toString()
				+" "+mode+" - "
				+ReflectionUtil.getCallerClass(3).getName() + ": \t"
				+arg0);
	}
	
	@Override
	public void catching(Throwable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void catching(Level arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(Message arg0) {
		// TODO Auto-generated method stub
		
	}	


	@Override
	public void debug(MessageSupplier arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(String arg0) {
		if (Severity.DEBUG.level >= severityLevel){
			System.out.println(getMessage("DEBUG", arg0));	
		}
	
	}

	@Override
	public void debug(Supplier<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(Marker arg0, Message arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(Marker arg0, MessageSupplier arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(Marker arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(Marker arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(Marker arg0, Supplier<?> arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(Message arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(MessageSupplier arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(Object arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(String arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(String arg0, Supplier<?>... arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(String arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(Supplier<?> arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(Marker arg0, Message arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(Marker arg0, MessageSupplier arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(Marker arg0, Object arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(Marker arg0, String arg1, Object... arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(Marker arg0, String arg1, Supplier<?>... arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(Marker arg0, String arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(Marker arg0, Supplier<?> arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entry() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entry(Object... arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(Message arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(MessageSupplier arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(String arg0) {
		System.out.println(getMessage("ERROR", arg0));		
	}

	@Override
	public void error(Supplier<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(Marker arg0, Message arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(Marker arg0, MessageSupplier arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(Marker arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(Marker arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(Marker arg0, Supplier<?> arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(Message arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(MessageSupplier arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(Object arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(String arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(String arg0, Supplier<?>... arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(String arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(Supplier<?> arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(Marker arg0, Message arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(Marker arg0, MessageSupplier arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(Marker arg0, Object arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(Marker arg0, String arg1, Object... arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(Marker arg0, String arg1, Supplier<?>... arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(Marker arg0, String arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(Marker arg0, Supplier<?> arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <R> R exit(R arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fatal(Message arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(MessageSupplier arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(Supplier<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(Marker arg0, Message arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(Marker arg0, MessageSupplier arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(Marker arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(Marker arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(Marker arg0, Supplier<?> arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(Message arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(MessageSupplier arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(Object arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(String arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(String arg0, Supplier<?>... arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(String arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(Supplier<?> arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(Marker arg0, Message arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(Marker arg0, MessageSupplier arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(Marker arg0, Object arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(Marker arg0, String arg1, Object... arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(Marker arg0, String arg1, Supplier<?>... arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(Marker arg0, String arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(Marker arg0, Supplier<?> arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Level getLevel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageFactory getMessageFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void info(Message arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(MessageSupplier arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(String arg0) {
		if (Severity.INFO.level >= severityLevel){
			System.out.println(getMessage("INFO", arg0));		
		}
	}

	@Override
	public void info(Supplier<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(Marker arg0, Message arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(Marker arg0, MessageSupplier arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(Marker arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(Marker arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(Marker arg0, Supplier<?> arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(Message arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(MessageSupplier arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(Object arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(String arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(String arg0, Supplier<?>... arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(String arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(Supplier<?> arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(Marker arg0, Message arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(Marker arg0, MessageSupplier arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(Marker arg0, Object arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(Marker arg0, String arg1, Object... arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(Marker arg0, String arg1, Supplier<?>... arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(Marker arg0, String arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(Marker arg0, Supplier<?> arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDebugEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDebugEnabled(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled(Level arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled(Level arg0, Marker arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isErrorEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isErrorEnabled(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFatalEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFatalEnabled(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInfoEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInfoEnabled(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTraceEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTraceEnabled(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWarnEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWarnEnabled(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void log(Level arg0, Message arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level arg0, MessageSupplier arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level arg0, Supplier<?> arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level arg0, Marker arg1, Message arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level arg0, Marker arg1, MessageSupplier arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level arg0, Marker arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level arg0, Marker arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level arg0, Marker arg1, Supplier<?> arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level arg0, Message arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level arg0, MessageSupplier arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level arg0, Object arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level arg0, String arg1, Object... arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level arg0, String arg1, Supplier<?>... arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level arg0, String arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level arg0, Supplier<?> arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level arg0, Marker arg1, Message arg2, Throwable arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level arg0, Marker arg1, MessageSupplier arg2, Throwable arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level arg0, Marker arg1, Object arg2, Throwable arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level arg0, Marker arg1, String arg2, Object... arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level arg0, Marker arg1, String arg2, Supplier<?>... arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level arg0, Marker arg1, String arg2, Throwable arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level arg0, Marker arg1, Supplier<?> arg2, Throwable arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printf(Level arg0, String arg1, Object... arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printf(Level arg0, Marker arg1, String arg2, Object... arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends Throwable> T throwing(T arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Throwable> T throwing(Level arg0, T arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void trace(Message arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(MessageSupplier arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Supplier<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Marker arg0, Message arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Marker arg0, MessageSupplier arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Marker arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Marker arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Marker arg0, Supplier<?> arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Message arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(MessageSupplier arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Object arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(String arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(String arg0, Supplier<?>... arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(String arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Supplier<?> arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Marker arg0, Message arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Marker arg0, MessageSupplier arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Marker arg0, Object arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Marker arg0, String arg1, Object... arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Marker arg0, String arg1, Supplier<?>... arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Marker arg0, String arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Marker arg0, Supplier<?> arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Message arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(MessageSupplier arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(String arg0) {
		if (Severity.WARN.level >= severityLevel){
			System.out.println(getMessage("WARN", arg0));			
		}
	}

	@Override
	public void warn(Supplier<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Marker arg0, Message arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Marker arg0, MessageSupplier arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Marker arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Marker arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Marker arg0, Supplier<?> arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Message arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(MessageSupplier arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Object arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(String arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(String arg0, Supplier<?>... arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(String arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Supplier<?> arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Marker arg0, Message arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Marker arg0, MessageSupplier arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Marker arg0, Object arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Marker arg0, String arg1, Object... arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Marker arg0, String arg1, Supplier<?>... arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Marker arg0, String arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Marker arg0, Supplier<?> arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}
	
	public static Logger getInstance(){
		return INSTANCE;
	}

}
