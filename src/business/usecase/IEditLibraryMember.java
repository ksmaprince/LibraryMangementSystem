package business.usecase;

import business.exception.InvalidMemberException;
import business.model.LibraryMember;

public interface IEditLibraryMember {
	public void editLibrary(LibraryMember member) throws InvalidMemberException;
}
