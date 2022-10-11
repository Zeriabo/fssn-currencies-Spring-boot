package com.fssn.service;

import org.springframework.stereotype.Component;

import com.fssn.exceptions.InputException;
import com.fssn.exceptions.LengthException;
import com.fssn.models.Fssn;
import com.fssn.models.PersonalIdentityCode;
import com.fssn.models.Response;

@Component
public class FssnServiceImpl implements FssnService {

	@Override
	public Response validate(Fssn fssn) throws Exception {

		Response response = new Response();

		String ssn = fssn.getSsn();
		String countryCode = fssn.getCountry_code();

		if (fssn.getCountry_code().length() > 2 || fssn.getCountry_code().length() < 2) {
			throw new LengthException(2, fssn.getCountry_code());
		}
		if (fssn.getSsn().length() > 11 || fssn.getSsn().length() < 11) {
			throw new LengthException(11, fssn.getSsn());
		}

		String testString = fssn.getSsn().substring(0, 6) + fssn.getSsn().substring(7, 10);
		if (!validateString(testString)) {
			throw new InputException(testString);
		}

		if (isAlpha(testString)) {
			throw new InputException(testString);
		}

		if (!countryCode.equals("FI")) {
			response.setMessage("Country code : " + countryCode + " is not supported yet");
			response.setResponse(false);
			return response;
		}

		if (ssn.charAt(6) == '-' || ssn.charAt(6) == '+' || ssn.charAt(6) == 'A') {
			String[] parts = ssn.split(Character.toString(ssn.charAt(6)));

			String firstPart = parts[0];

			String secoundPart = parts[1];

			Character last = secoundPart.charAt(secoundPart.length() - 1);

			StringBuilder sb = new StringBuilder(parts[1]);

			sb.deleteCharAt(parts[1].length() - 1);

			String secountNumber = sb.toString();

			String partsString = (parts[0] + secountNumber);

			int partsInt;
			try {
				partsInt = Integer.parseInt(partsString);
			} catch (Exception e) {
				response.setMessage("Your input is invalid! check: " + partsString);
				response.setResponse(false);
				return response;
			}

			int individualNumber = Integer.parseInt(secountNumber);

			if (!validateDob(firstPart)) {
				response.setResponse(false);
				response.setMessage("Date of birth is not valid");
				return response;
			}

			if (!validateIndividualNumber(individualNumber)) {
				response.setResponse(false);
				response.setMessage("individual number is not valid");
				return response;
			}
			boolean k = validateControlCharacter(partsInt, last);

			if (k != true) {
				response.setResponse(false);
				response.setMessage("Control character is not valid");
				return response;
			}

		} else {
			response.setMessage("The sign or date of birth is not valid!");
			response.setResponse(false);
			return response;
		}
		response.setMessage("Validation succeeded");
		response.setResponse(true);
		return response;
	}

	public boolean validateDob(String dob) {

		String[] dateOfBirth = dob.split("(?<=\\G.{" + 2 + "})");

		boolean validatedob = false;

		if (dob.length() == 6) {
			if (Integer.parseInt(dateOfBirth[1]) == 1 || Integer.parseInt(dateOfBirth[1]) == 3
					|| Integer.parseInt(dateOfBirth[1]) == 5 || Integer.parseInt(dateOfBirth[1]) == 7
					|| Integer.parseInt(dateOfBirth[1]) == 8 || Integer.parseInt(dateOfBirth[1]) == 10
					|| Integer.parseInt(dateOfBirth[1]) == 12 && (Integer.parseInt(dateOfBirth[0]) == 31)) {
				validatedob = true;
			}
			if (Integer.parseInt(dateOfBirth[1]) == 4 || Integer.parseInt(dateOfBirth[1]) == 6
					|| Integer.parseInt(dateOfBirth[1]) == 9
					|| Integer.parseInt(dateOfBirth[1]) == 11 && (Integer.parseInt(dateOfBirth[0]) == 30)) {
				validatedob = true;
			}
			if (Integer.parseInt(dateOfBirth[1]) == 2
					&& (Integer.parseInt(dateOfBirth[0]) <= 29 || (Integer.parseInt(dateOfBirth[0]) <= 28))) {
				validatedob = true;
			}
		}

		return validatedob;
	}

	public boolean validateIndividualNumber(int individualNumber) {

		return Integer.toString(individualNumber).toString().length() == 3
				&& (individualNumber > 2 && individualNumber < 889);
	}

	public boolean validateControlCharacter(int individualNumber, Character toCompare) {
		int result = individualNumber % 31;
		if (result > 30) {
			return false;
		}

		Character c = PersonalIdentityCode.getCharacter(result);

		if (c.equals(toCompare)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean validateString(String string) {
		char[] chars = string.toCharArray();
		boolean contains = false;
		for (char c : chars) {
			if (Character.isDigit(c)) {
				contains = true;

			}
		}
		return contains;
	}

	public static boolean isAlpha(String s) {
		boolean isalpha = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (!Character.isDigit(c)) {
				isalpha = true;
			}
		}

		return isalpha;
	}
}
