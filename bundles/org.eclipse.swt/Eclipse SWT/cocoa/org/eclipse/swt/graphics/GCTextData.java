package org.eclipse.swt.graphics;

import org.eclipse.swt.internal.cocoa.*;

/**
 * Instances of this class are descriptions of GCs for text drawing in terms of
 * platform-specific data fields. Can be cached to improve repeat render
 * performance.
 */
class GCTextData {

	private NSPoint pt = new NSPoint();

	private NSTextContainer textContainer;
	private NSLayoutManager layoutManager;
	private NSTextStorage textStorage;

	private NSRange range;

	public GCTextData(NSAttributedString attribStr) {
		NSSize size = new NSSize();
		size.width = OS.MAX_TEXT_CONTAINER_SIZE;
		size.height = OS.MAX_TEXT_CONTAINER_SIZE;
		NSTextStorage textStorage = (NSTextStorage)new NSTextStorage().alloc().init();
		NSLayoutManager layoutManager = (NSLayoutManager)new NSLayoutManager().alloc().init();
		layoutManager.setBackgroundLayoutEnabled(NSThread.isMainThread());
		NSTextContainer textContainer = (NSTextContainer)new NSTextContainer().alloc();
		textContainer = textContainer.initWithContainerSize(size);
		textContainer.setLineFragmentPadding(0);
		textStorage.addLayoutManager(layoutManager);
		layoutManager.addTextContainer(textContainer);
		layoutManager.release();
		textContainer.release();
		this.textContainer = textContainer;
		this.layoutManager = layoutManager;
		this.textStorage = textStorage;
		textStorage.setAttributedString(attribStr);
		this.range = layoutManager.glyphRangeForTextContainer(textContainer);
	}

	public void release() {
		if (textStorage != null) textStorage.release();
		textStorage = null;
		layoutManager = null;
		textContainer = null;
	}

	public void draw(int x, int y) {
		pt.x = x;
		pt.y = y;
		layoutManager.drawGlyphsForGlyphRange(range, pt);
	}

}
