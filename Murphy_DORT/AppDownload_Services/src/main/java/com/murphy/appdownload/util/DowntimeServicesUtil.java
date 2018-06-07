package com.murphy.appdownload.util;

import java.net.Authenticator;
import java.util.Base64;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DowntimeServicesUtil {

	private static final Logger logger = LoggerFactory.getLogger(DowntimeServicesUtil.class);

	public static void setupSOCKS() {
		try {
			String auth = setSOCKS5ProxyAuthentication(DowntimeConstant.CLOUD_SUBACCOUNT_NAME,
					DowntimeConstant.CLOUD_LOCATION);
			System.setProperty(DowntimeConstant.SOCK_HOST_NAME, DowntimeConstant.SOCKS_HOST);
			System.setProperty(DowntimeConstant.SOCKS_PORT_NAME, DowntimeConstant.SOCKS_PORT);
			System.setProperty("java.net.socks.username", auth);
		} catch (Exception e) {
			logger.error("Proxy Setup Exception : " + e.getMessage());
		}

	}

	private static String setSOCKS5ProxyAuthentication(String subaccount, String locationId) {
		final String encodedSubaccount = new String(Base64.getEncoder().encodeToString(subaccount.getBytes()));
		final String encodedLocationId = new String(Base64.getEncoder().encodeToString(locationId.getBytes()));
		Authenticator.setDefault(new Authenticator() {
			@Override
			protected java.net.PasswordAuthentication getPasswordAuthentication() {
				return new java.net.PasswordAuthentication("1." + encodedSubaccount + "." + encodedLocationId,
						new char[] {});
			}
		});
		return "1." + encodedSubaccount + "." + encodedLocationId;
	}

	public static void unSetupSOCKS() {
		try {
			System.setProperty(DowntimeConstant.SOCK_HOST_NAME, "");
			System.setProperty(DowntimeConstant.SOCKS_PORT_NAME, "");
			System.setProperty("java.net.socks.username", "");
		} catch (Exception e) {
			logger.error("Proxy Unsetup Exception : " + e.getMessage());
		}
	}

	public static String getQueryString(Set<Integer> inputSet, String initialQuery, List<Integer> inputList) {
		if (inputSet != null && inputSet.size() > 0) {
			inputList.addAll(inputSet);
		}
		String responseString = "";
		if (inputList != null && inputList.size() > 0) {
			if (inputList.size() < 1000) {
				String tempString = "";
				for (int i = 0; i < inputList.size(); i++) {
					if (i == 0) {
						tempString = "'" + inputList.get(i) + "'";
					} else
						tempString = tempString + ", '" + inputList.get(i) + "'";
				}
				responseString = (initialQuery + " IN (" + tempString + ")");
			} else {
				double size = inputList.size();
				double chunkSize = 999;
				StringBuffer inputListBuffer = new StringBuffer("");
				int numOfChunks = (int) Math.ceil((double) size / chunkSize);
				for (int i = 0; i < numOfChunks; ++i) {
					int start = (int) (i * chunkSize);
					int countSize = (int) Math.min(size - start, chunkSize);
					String tempString = "";
					for (int j = start; j < start + countSize; j++) {
						if (j == start) {
							tempString = "'" + inputList.get(j) + "'";
						} else
							tempString = tempString + ", '" + inputList.get(j) + "'";
					}
					if (i == 0)
						inputListBuffer.append("(" + initialQuery + " IN (" + tempString + ") ");
					else
						inputListBuffer.append("OR " + initialQuery + " IN (" + tempString + ") ");

				}
				responseString = inputListBuffer.toString() + ")";
			}
		}
		return responseString;
	}
}
