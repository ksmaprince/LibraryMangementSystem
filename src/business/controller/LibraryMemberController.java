package business.controller;

import business.usecase.IAddLibraryMember;
import business.usecase.ICheckMember;
import dataaccess.DataAccessFacade;
import business.model.LibraryMember;
import business.exception.InvalidMemberException;
import dataaccess.repository.child.LibraryMemberRepository;

public class LibraryMemberController extends BaseController implements IAddLibraryMember, ICheckMember {
	LibraryMemberController() {
	}

	@Override
	public void addLibraryMember(LibraryMember member) throws InvalidMemberException {
		LibraryMemberRepository libMemRepo = new LibraryMemberRepository(new DataAccessFacade());
		libMemRepo.addLibraryMember(member);
	}

	@Override
	public boolean checkMember(String memberId) {

		LibraryMemberRepository libMemRepo = new LibraryMemberRepository(new DataAccessFacade());

		return libMemRepo.checkMember(memberId);


	}

	@Override
	public LibraryMember getMember(String memberId) {
		LibraryMemberRepository libMemRepo = new LibraryMemberRepository(new DataAccessFacade());
		return libMemRepo.getMember(memberId);

	}


}
