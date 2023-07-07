package business.usecase;

import business.model.LibraryMember;
import business.exception.InvalidMemberException;

public interface IAddLibraryMember {
	public void addLibraryMember(LibraryMember member) throws InvalidMemberException;
}
