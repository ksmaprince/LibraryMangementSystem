package business.usecase;

import business.model.LibraryMember;

public interface ICheckMember {
	public boolean checkMember(String memberId);

	public LibraryMember getMember(String memberId);
}
