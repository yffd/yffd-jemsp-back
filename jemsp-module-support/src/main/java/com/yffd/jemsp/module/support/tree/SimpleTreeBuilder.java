package com.yffd.jemsp.module.support.tree;

public class SimpleTreeBuilder<N extends Treeable<N>> extends AbstractTreeBuilder<N, N> {

	@Override
	public N convert(N obj) {
		return obj;
	}

}
