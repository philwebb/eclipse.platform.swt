/*******************************************************************************
 * Copyright (c) 2000, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.internal.win32;

public class NMLVDISPINFO extends NMHDR {
//	LVITEM item;
	public int mask;
	public int iItem;
	public int iSubItem;
	public int state;
	public int stateMask;
	public int pszText;
	public int cchTextMax;
	public int iImage;
	public int lParam;
	public int iIndent;
	public static final int sizeof = 52;
}
