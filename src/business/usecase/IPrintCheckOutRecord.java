package business.usecase;

import business.model.CheckOutRecord;

public interface IPrintCheckOutRecord {
	public CheckOutRecord getCheckOutRecord(String memberId);
}
