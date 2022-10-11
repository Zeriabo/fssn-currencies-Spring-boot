package com.fssn.service;

import com.fssn.models.Fssn;
import com.fssn.models.Response;

public interface FssnService {

	public Response validate(Fssn body) throws Exception;

}
