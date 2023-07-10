package business.usecase;

import dataaccess.model.CheckOutRecord;

public interface IPrintCheckOutRecord {
	public CheckOutRecord getCheckOutRecord(String memberId);
}
