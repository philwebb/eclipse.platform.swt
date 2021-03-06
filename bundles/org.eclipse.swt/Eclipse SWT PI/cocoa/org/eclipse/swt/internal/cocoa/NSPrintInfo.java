/*******************************************************************************
 * Copyright (c) 2000, 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.internal.cocoa;

public class NSPrintInfo extends NSObject {

public NSPrintInfo() {
	super();
}

public NSPrintInfo(long /*int*/ id) {
	super(id);
}

public NSPrintInfo(id id) {
	super(id);
}

public long /*int*/ PMPrintSession() {
	return OS.objc_msgSend(this.id, OS.sel_PMPrintSession);
}

public long /*int*/ PMPrintSettings() {
	return OS.objc_msgSend(this.id, OS.sel_PMPrintSettings);
}

public static NSPrinter defaultPrinter() {
	long /*int*/ result = OS.objc_msgSend(OS.class_NSPrintInfo, OS.sel_defaultPrinter);
	return result != 0 ? new NSPrinter(result) : null;
}

public NSMutableDictionary dictionary() {
	long /*int*/ result = OS.objc_msgSend(this.id, OS.sel_dictionary);
	return result != 0 ? new NSMutableDictionary(result) : null;
}

public NSRect imageablePageBounds() {
	NSRect result = new NSRect();
	OS.objc_msgSend_stret(result, this.id, OS.sel_imageablePageBounds);
	return result;
}

public NSPrintInfo initWithDictionary(NSDictionary attributes) {
	long /*int*/ result = OS.objc_msgSend(this.id, OS.sel_initWithDictionary_, attributes != null ? attributes.id : 0);
	return result == this.id ? this : (result != 0 ? new NSPrintInfo(result) : null);
}

public boolean isSelectionOnly() {
	return OS.objc_msgSend_bool(this.id, OS.sel_isSelectionOnly);
}

public NSString jobDisposition() {
	long /*int*/ result = OS.objc_msgSend(this.id, OS.sel_jobDisposition);
	return result != 0 ? new NSString(result) : null;
}

public NSSize paperSize() {
	NSSize result = new NSSize();
	OS.objc_msgSend_stret(result, this.id, OS.sel_paperSize);
	return result;
}

public NSMutableDictionary printSettings() {
	long /*int*/ result = OS.objc_msgSend(this.id, OS.sel_printSettings);
	return result != 0 ? new NSMutableDictionary(result) : null;
}

public NSPrinter printer() {
	long /*int*/ result = OS.objc_msgSend(this.id, OS.sel_printer);
	return result != 0 ? new NSPrinter(result) : null;
}

public void setJobDisposition(NSString disposition) {
	OS.objc_msgSend(this.id, OS.sel_setJobDisposition_, disposition != null ? disposition.id : 0);
}

public void setPrinter(NSPrinter printer) {
	OS.objc_msgSend(this.id, OS.sel_setPrinter_, printer != null ? printer.id : 0);
}

public void setSelectionOnly(boolean selectionOnly) {
	OS.objc_msgSend(this.id, OS.sel_setSelectionOnly_, selectionOnly);
}

public void setUpPrintOperationDefaultValues() {
	OS.objc_msgSend(this.id, OS.sel_setUpPrintOperationDefaultValues);
}

public static NSPrintInfo sharedPrintInfo() {
	long /*int*/ result = OS.objc_msgSend(OS.class_NSPrintInfo, OS.sel_sharedPrintInfo);
	return result != 0 ? new NSPrintInfo(result) : null;
}

public void updateFromPMPrintSettings() {
	OS.objc_msgSend(this.id, OS.sel_updateFromPMPrintSettings);
}

}
